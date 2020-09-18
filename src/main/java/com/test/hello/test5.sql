select ag.id                  as                                     id,
       (coalesce((g.path || '/'), '/') || coalesce(nullif(prnt.full_name || '/', '/'), '') ||
        ag.full_name)         as                                     name,
       uu.login               as                                     phone,
       sc.id                  as                                     center_id,
       sc.number              as                                     centernumber,
       sc.name                as                                     center,
       oper.full_names        as                                     identname,
       oper.phone             as                                     identphone,
       pp.name                as                                     partner,
       us.login               as                                     login,
       uu.created_dt          as                                     createdate,
       min(ch.reg_date)       as                                     identdate,
       sum(case when pt.status_id = 'SUCCESS' and pt.created_dt
           between '2020-01-01' and '2020-03-01' then pt.amount  else 0 end) as paidsum,
       min(case when pt.status_id = 'SUCCESS' and pt.created_dt
           between '2020-01-01' and '2020-03-01' then pt.created_dt else null end) as paiddate,
       (select count(*) from users clnt where clnt.id = ag.user_id
                                          and clnt.created_dt between '2020-01-01' and '2020-02-01') regmonth
from cashier_history ch
         inner join agents ag on ag.id = ch.cashier_id
         inner join groups g on ag.group_id = g.id
         inner join users uu on ag.user_id = uu.id
         inner join users us on us.id = ch.change_user_id
         inner join sales_center_users oper on us.id = ch.change_user_id and ch.change_user_id = oper.user_id
         inner join sales_centers sc on sc.id = oper.sales_center_id
         left outer join agents prnt on prnt.id = ag.parent_id
         left outer join partners pp on pp.id = oper.partner_id
         left outer join payments pt on ag.id = pt.agent_id
where ch.is_ident = true
  and (g.id = 0 or 0 = 0)
  and (us.id = 0 or 0 = 0)
  and (ag.id = 0 or 0 = 0)
  and (sc.id = 0 or 0 = 0)
  and (ch.reg_date between '2020-01-01' and '2020-05-01')
group by ag.id, uu.login, sc.id, sc.number, sc.name, oper.full_names, oper.phone, pp.name, us.login, uu.created_dt,
         g.path, prnt.full_name
order by sc.id, sc.number, sc.name, pp.name, oper.full_names, oper.phone, uu.login;