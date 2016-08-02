# _Hair Salon App_

#### _Epicodus Java class, May 2016_

#### **By Farnoosh Johnson**

###### _[Java database basics](https://www.learnhowtoprogram.com/java/java-database-basics/database-basics-independent-project-c78ee055-12ad-4223-8b28-0ea3da1d0762)_

###### **Hair Salon, code review number 3**

## __Description__

###### This is simple custom-made Hair Salon application that receive the stylist name from the user, let the user add unlimited clients for each stylists in a different page. The homepage of the app list out all of the stylists, and user can click on each stylist name to view all of clients for the selected stylist. the input is required to be filled in order the submit button redirect to the next page.This app does not have the ability to let user whether any word is duplicated.
######Below objective has been met in this App;
1. Test have complete coverage for the behaviors that need to be tested
2. tests are passing
3. code has proper indentation and spacing
4. Variable names are descriptive
5. Use of standard naming conventions for database tables and columns
6. At least one Integration spec is in place for each page
7. Use of RESTful routes in Spark
8. An instance of one class appears in the method of another class
9. Execution of CRUD functionality in methods and routes
10. Recource names will be clients and stylists
11. Spark routes process GET and POST requests/responses successfully
12. Correct set up of a one-to-many relationship in a database
13. README file include the details of your database names and tables

####Screenshots of some pages of the app:
<img id="screen-1" src="https://s26.postimg.org/t8m2nr54p/Screen_Shot_2016_08_02_at_11_00_13_AM.png" width="200px" title="main page" />
<img id="screen-1" src="https://s26.postimg.org/fsz1yawmx/Screen+Shot 2016-08-02 at 11.01.45 AM.png" width="200px" title="add customer" />
<img id="screen-1" src="https://s26.postimg.org/93siiabax/Screen_Shot_2016_08_02_at_11_02_34_AM.png" width="200px" title="Manage stylist" />
> You may use this application as an example to show the proficiency of a level 2 student in Epicodus.
Setup:

This website is designed with bootstrap _version 3.3.6_ and including following files:
* four different template files for index, layout and clients form and stylists
* one custom-made CSS files
* two java testing file for back-end and one for integration test to test the front-end
* two java files for the method two different classes
* one database connection java file
* one ServerRule java and one DatabaseRule file
* One App java file for Spark route
* one velocityTemplateEngine
* .ignore file
* build gradle file
* Procfile for deploying Spark apps to Heroku
* one .sql file for database backup

###### Thanks

**Accessing to the remote repository on account :** [farnoosh63](https://github.com/Farnoosh63/HairSalon.git)

**Accessing to github pages for this application :**
> there is no github page created for this app


**Installation:**
>fork, download(gradle build) and run on gradle then visit http://localhost:4567/
>In PSQL:
* CREATE DATABASE hair_salon;
* connect to database
* CREATE TABLE stylists (id serial PRIMARY KEY, name varchar);
* CREATE TABLE clients (id serial PRIMARY KEY, name varchar, stylistid int);


**common SQL commands:**
* CREATE DATABASE database_name; # From the $USER database.
* CREATE TABLE table_name (id serial PRIMARY KEY, some_column varchar, another_column int, yet_another_column timestamp);
* ALTER TABLE table_name ADD column_name boolean;
* ALTER TABLE table_name DROP column_name;
* INSERT INTO contacts (name, age, birthday) VALUES ('Wes', 43, '1969-05-01') RETURNING id;
* SELECT * FROM table_name WHERE age >= 18;
* SELECT * FROM contacts WHERE NOT age >= 18;
* UPDATE contacts SET name = 'Wes Anderson' WHERE id = 1;
* DELETE FROM contacts WHERE id = 1;
* DROP TABLE table_name; # From the database that holds the table.
* DROP DATABASE test_database; # From the $USER database.

```
Restoring Databases
Restoring databases from an .sql file takes a few more steps - we must manually create the database we want to add our tables to before we can add them.

Connect to psql and run:

# CREATE DATABASE media;
Now we can restore your media.sql including our films table in our terminal:

$ psql media < media.sql
We should see something like this:

COPY 0
 setval 
--------
     17
(1 row)

COPY 3
 setval 
--------
     38
(1 row)

ALTER TABLE
ALTER TABLE
ALTER TABLE
REVOKE
REVOKE
GRANT
GRANT
If we switch to psql and run:

# \c media
and then:

\dt 
We will see all of our tables in the media database.
```

### Legal

_*Copyright (c) 2016 Farnoosh Johnson- Student in Epicodus*_

###### This software is licensed under the MIT license.

###### Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

__The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.__

###### THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
