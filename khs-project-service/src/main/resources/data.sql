insert into project(id, name, description, hours, budget) values (1, 'Project A', 'This is the description for Project A', 1000, 50000);
insert into project(id, name, description, hours, budget) values (2, 'Project B', 'This is the description for Project B', 2000, 75000);
insert into project(id, name, description, hours, budget) values (3, 'Project C', 'This is the description for Project C', 3000, 100000);

insert into project_resource(id, role, manhours, project_id, employee_id) values (1, 'Developer', 30, 1, 1);
insert into project_resource(id, role, manhours, project_id, employee_id) values (2, 'Developer', 45, 1, 2);

insert into project_resource(id, role, manhours, project_id, employee_id) values (3, 'Developer', 30, 2, 3);
insert into project_resource(id, role, manhours, project_id, employee_id) values (4, 'Developer', 45, 2, 4);
insert into project_resource(id, role, manhours, project_id, employee_id) values (5, 'Developer', 50, 2, 5);

insert into project_resource(id, role, manhours, project_id, employee_id) values (6, 'Developer', 30, 3, 6);
insert into project_resource(id, role, manhours, project_id, employee_id) values (7, 'Developer', 45, 3, 7);