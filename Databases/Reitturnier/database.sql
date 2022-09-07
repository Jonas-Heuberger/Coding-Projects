create database Reitverein;
go
use Reitturnier;

create table Verantstalltung 
(
    VerantstalltungsID uniqueidentifier,
    datum date not null,
    ort nvarchar not null,
    leiter nvarchar not null,
    anmeldetermin date not null
);
go

create table Sponsor
(
    SponsorID uniqueidentifier,
   betrag money not null,
);
go

create table Reiter 
(
    ReiterID uniqueidentifier,
    name nvarchar not null,
    vorname nvarchar not null,
    adresse nvarchar not null,
    lizenznummer int not null,
);

