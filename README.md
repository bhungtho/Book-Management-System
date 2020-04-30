# Book-Tracker

A program to store books (such as the books a user has read), and view various statistics about the books stored. Written in Java, with database management using PostgreSQL.

How to use:

Starting point: BookTrackerJava.java

ONLY DO STEPS 1-2 THE FIRST TIME YOU RUN THE PROGRAM
1. I can't figure out a way to create a PostgreSQL database from within Java, so in order to do so, you have to use the command line. I used psql, so after opening psql, enter the command "CREATE DATABASE name;", where name is the name of your database. After this step, everything can be done within Java.
2. Create a table to hold the books (D -> A)

3. Now, you can add books (A), delete books (D), view the books currently stored (C), and view some statistics (B).

In-Progress:
- storing book information in PostgreSQL
- MORE STATISTICS

To-do:
- graphs????
- GUI

Done:
- add read-date to Book class

