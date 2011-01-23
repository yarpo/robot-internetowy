CREATE  TABLE "main"."documents" (
	"id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 
	"url" CHAR, 
	"date" DATETIME DEFAULT CURRENT_DATE
)

CREATE TABLE "main"."links" (
	"id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , 
	"id_from_document" INTEGER NOT NULL , 
	"url" CHAR NOT NULL , 
	"id_to_document" INTEGER
)
