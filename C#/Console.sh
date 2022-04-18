// create a console application
dotnet new console -o Program.cs

// go into the project directory
cd Program.cs

// run the application
dotnet run

// Add Packages
dotnet add

// Codegenerator
dotnet-aspnet-codegenerator controller -name StudentsController -m StudentsController -dc SchoolContext --relativeFolderPath Controllers --useDefaultLayout --referenceScriptLibraries -sqlite
