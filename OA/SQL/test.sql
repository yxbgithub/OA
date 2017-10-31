select * from t_user;
select * from t_role;
select * from t_user_t_role;
select * from t_department;
select * from user_constraints;
select * from t_privilege;
select * from t_role_t_privilege;
//查询所有的外键
select * from user_constraints c where c.constraint_type = 'R';
//查询键的名称为FKE5E6F90ACC2DED5E的键的信息
select * from user_cons_columns cl where cl.constraint_name = 'SYS_C0017639';