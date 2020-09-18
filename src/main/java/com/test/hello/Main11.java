package com.test.hello;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author NIsaev on 07.09.2020
 */

public class Main11 {

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark SQL basic example")
                .config("spark.master", "local")
                .config("spark.sql.warehouse.dir", "C:/spark/spark-3.0.0-bin-hadoop3.2/examples/src/main/resources")
                .config("spark.driver.memory", 471859200)
                .config("spark.testing.memory", 2147480000)
                .getOrCreate();

        logic1(spark);
        logic2(spark);
    }

    static void logic1(SparkSession spark) {
        Person person = new Person();
        person.setName("Andy");
        person.setAge(32);

        // Encoders are created for Java beans
        Encoder<Person> personEncoder = Encoders.bean(Person.class);
        Dataset<Person> javaBeanDS = spark.createDataset(
                Collections.singletonList(person),
                personEncoder);
        javaBeanDS.show();

        // Encoders for most common types are provided in class Encoders
        Encoder<Integer> integerEncoder = Encoders.INT();
        Dataset<Integer> primitiveDS = spark.createDataset(Arrays.asList(1, 2, 3), integerEncoder);
        Dataset<Integer> transformedDS = primitiveDS.map(
                (MapFunction<Integer, Integer>) value -> value + 1,
                integerEncoder);
        transformedDS.collect(); // Returns [2, 3, 4]

        // DataFrames can be converted to a Dataset by providing a class. Mapping based on name
        String path = "C:/spark/spark-3.0.0-bin-hadoop3.2/examples/src/main/resources/people.json";
        Dataset<Person> peopleDS = spark.read().
                json(path).
                as(personEncoder);
        peopleDS.show();

        ////////////////////////////

        // Create an RDD of Person objects from a text file
        JavaRDD<Person> peopleRDD = spark.read()
                .textFile("C:/spark/spark-3.0.0-bin-hadoop3.2/examples/src/main/resources/people.txt")
                .javaRDD()
                .map(line -> {
                    String[] parts = line.split(",");
                    Person person1 = new Person();
                    person1.setName(parts[0]);
                    person1.setAge(Integer.parseInt(parts[1].trim()));
                    return person1;
                });

        // Apply a schema to an RDD of JavaBeans to get a DataFrame
        Dataset<Row> peopleDF = spark.createDataFrame(peopleRDD, Person.class);
        // Register the DataFrame as a temporary view
        peopleDF.createOrReplaceTempView("people");

        // SQL statements can be run by using the sql methods provided by spark
        Dataset<Row> teenagersDF = spark.sql("SELECT name, age FROM people WHERE age BETWEEN 13 AND 19");

        // The columns of a row in the result can be accessed by field index
        Encoder<String> stringEncoder = Encoders.STRING();
        Encoder<Long> longEncoder = Encoders.LONG();
        Dataset<String> teenagerNamesByIndexDF = teenagersDF.map(
                (MapFunction<Row, String>) row -> "Name: " + row.getString(0),
                stringEncoder);
        teenagerNamesByIndexDF.show();

        // or by field name
        Dataset<String> teenagerNamesByFieldDF = teenagersDF.map(
                (MapFunction<Row, String>) row -> "Name: " + row.<String>getAs("name"),
                stringEncoder);
        teenagerNamesByFieldDF.show();

        // or by field name
        Dataset<String> teenagerAgeByFieldDF = teenagersDF.map(
                (MapFunction<Row, String>) row -> row.<String>getAs("name") + ", Age: " + row.<Long>getAs("age"),
                stringEncoder);
        teenagerAgeByFieldDF.show();
    }

    static void logic2(SparkSession spark) {
        // Create an RDD
        JavaRDD<String> peopleRDD = spark.sparkContext()
                .textFile("C:/spark/spark-3.0.0-bin-hadoop3.2/examples/src/main/resources/people.txt", 1)
                .toJavaRDD();

        // The schema is encoded in a string
        String schemaString = "name age";

        // Generate the schema based on the string of schema
        List<StructField> fields = new ArrayList<>();
        for (String fieldName : schemaString.split(" ")) {
            StructField field = DataTypes.createStructField(fieldName, DataTypes.StringType, true);
            fields.add(field);
        }
        StructType schema = DataTypes.createStructType(fields);

        // Convert records of the RDD (people) to Rows
        JavaRDD<Row> rowRDD = peopleRDD.map((Function<String, Row>) record -> {
            String[] attributes = record.split(",");
            return RowFactory.create(attributes[0], attributes[1].trim());
        });

        // Apply the schema to the RDD
        Dataset<Row> peopleDataFrame = spark.createDataFrame(rowRDD, schema);

        // Creates a temporary view using the DataFrame
        peopleDataFrame.createOrReplaceTempView("people");

        // SQL can be run over a temporary view created using DataFrames
        Dataset<Row> results = spark.sql("SELECT name, age FROM people");

        // The results of SQL queries are DataFrames and support all the normal RDD operations
        // The columns of a row in the result can be accessed by field index or by field name
        Dataset<String> namesDS = results.map(
                (MapFunction<Row, String>) row -> "Name: " + row.getString(0)+ ", Age: " + row.getString(1),
                Encoders.STRING());
        namesDS.show();
    }

    public static class Person implements Serializable {
        private long age;
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getAge() {
            return age;
        }

        public void setAge(long age) {
            this.age = age;
        }
    }
}
