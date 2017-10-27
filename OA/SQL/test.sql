select * from t_user;
select * from t_role;
select * from t_user_t_role;
select * from t_department;
select * from user_constraints;
//查询所有的外键
select * from user_constraints c where c.constraint_type = 'R';
//查询键的名称为FKE5E6F90ACC2DED5E的键的信息
select * from user_cons_columns cl where cl.constraint_name = 'FKE5E6F90ACC2DED5E';