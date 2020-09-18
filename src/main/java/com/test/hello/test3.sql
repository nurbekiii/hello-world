select *
from (select ag.id                                                                                                as id,
             (coalesce((g.path || '/'), '/') || coalesce(nullif(prnt.full_name || '/', '/'), '') ||
              ag.full_name)                                                                                       as name,
             a.phone,
             sc.id                                                                                                as center_id,
             sc.number                                                                                            as centernumber,
             sc.name                                                                                              as center,
             scu.full_names                                                                                       as identname,
             scu.phone                                                                                            as identphone,
             pp.name                                                                                              as partner,
             us.login                                                                                             as login,
             uu.created_dt                                                                                        as createdate,
             min(ch.reg_date)                                                                                     as identdate,
             coalesce(sum(pt.amount), 0)                                                                          as paidsum,
             min(pt.created_dt)                                                                                   as paiddate,
             (select count(*)
              from users clnt
              where clnt.id = ag.user_id and clnt.created_dt between :date_beg and :date_end)                        regmonth
      from cashiers a
               inner join agents ag on a.id = ag.id
               inner join users uu on ag.user_id = uu.id
               inner join cashier_history ch on a.id = ch.cashier_id
               inner join users us on us.id = ch.change_user_id
               inner join sales_center_users scu on us.id = scu.user_id and scu.user_id = ch.change_user_id
               inner join sales_centers sc on sc.id = scu.sales_center_id
               left outer join groups g on ag.group_id = g.id
               left outer join agents prnt on prnt.id = ag.parent_id
               left outer join partners pp on scu.partner_id = pp.id
               left outer join payments pt on pt.agent_id = ag.id
      where ch.is_ident = true
        and (g.id = :group_id or g.id = :group_id + g.id)
        and (ag.id = :agent_id or ag.id = :agent_id + ag.id)
        and (sc.id = :center_id or sc.id = :center_id + sc.id)
        and (us.id = :user_id or us.id = :user_id + us.id)
        and (ch.reg_date between :date_beg and :date_end)
        and (pt.status_id = 'SUCCESS' and pt.created_dt between :date_beg and :date_end_ex)
      group by ag.id, a.phone, sc.id, sc.number, sc.name, scu.full_names, scu.phone, pp.name, us.login, uu.created_dt,
               g.path, prnt.full_name
      order by sc.id, sc.number, sc.name, pp.name, scu.full_names, scu.phone, a.phone) account_balance
order by 4, 5, 6, 3 asc