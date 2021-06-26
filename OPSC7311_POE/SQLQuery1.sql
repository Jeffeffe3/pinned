CREATE DATABASE Pinned

USE Pinned

CREATE TABLE tblUsers(
Id int IDENTITY(1,1) NOT NULL,
UserId nvarchar(50) NOT NULL,
Password nvarchar(50) NOT NULL,
onDate dateTime NULL DEFAULT (getdate()),
UserRole nvarchar(50) NULL
)

