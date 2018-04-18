------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE INGREDIENT_TYPE (
	ID INT NOT NULL UNIQUE IDENTITY(1,1),
	CATEGORY VARCHAR(20) NOT NULL,
		CONSTRAINT PK_INGREDIENT_TYPE PRIMARY KEY(ID)
);
------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE BRAND (
	ID INT NOT NULL UNIQUE IDENTITY(1,1),
	NAME VARCHAR(50),
		CONSTRAINT PK_BRAND PRIMARY KEY(ID)
);
------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE INGREDIENT (
	ID INT NOT NULL UNIQUE IDENTITY(1,1),
	NAME VARCHAR(30),
	ABV DECIMAL(5,2) NOT NULL,
	INGREDIENT_TYPE_ID INT NOT NULL DEFAULT(0),
	BRAND_ID INT,
		CONSTRAINT PK_INGREDIENT PRIMARY KEY(ID),
		CONSTRAINT CHK_INGREDIENT_ABV CHECK(ABV BETWEEN 0 AND 100),
		CONSTRAINT FK_INGREDIENT_INGREDIENT_TYPE_ID FOREIGN KEY(INGREDIENT_TYPE_ID) REFERENCES INGREDIENT_TYPE(ID),
		CONSTRAINT FK_INGREDIENT_BRAND_ID FOREIGN KEY(BRAND_ID) REFERENCES BRAND(ID)
);
------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE GLASSWARE (
	ID INT NOT NULL UNIQUE IDENTITY(1,1),
	NAME VARCHAR(30),
	DESCRIPTION TEXT,
		CONSTRAINT PK_GLASSWARE PRIMARY KEY(ID)
);
------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE MIXED_DRINK (
	ID INT NOT NULL UNIQUE IDENTITY(1,1),
	NAME VARCHAR(30),
	INSTRUCTIONS TEXT,
	GLASS_ID INT NOT NULL DEFAULT(0),
		CONSTRAINT PK_MIXED_DRINK_ID PRIMARY KEY(ID),
		CONSTRAINT FK_MIXED_DRINK_GLASS_ID FOREIGN KEY(GLASS_ID) REFERENCES GLASSWARE(ID)
);
------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE INGREDIENT_MIX (
	ID INT NOT NULL UNIQUE IDENTITY(1,1),
	INGREDIENT_ID INT NOT NULL DEFAULT(0),
	MIXED_DRINK_ID INT NOT NULL DEFAULT(0),
	RATIO INT NOT NULL DEFAULT(0),
	UNIT VARCHAR(10) DEFAULT(NULL),
		CONSTRAINT PK_INGREDIENT_MIX PRIMARY KEY(ID),
		CONSTRAINT CHK_INGREDIENT_MIX CHECK(RATIO >= 0),
		CONSTRAINT FK_INGREDIENT_MIX_INGREDIENT_ID FOREIGN KEY(INGREDIENT_ID) REFERENCES INGREDIENT(ID),
		CONSTRAINT FK_INGREDIENT_MIX_MIXED_DRINK_ID FOREIGN KEY(MIXED_DRINK_ID) REFERENCES MIXED_DRINK(ID)
);
------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE GARNISH (
	ID INT NOT NULL UNIQUE IDENTITY(1,1),
	TYPE VARCHAR(30),
		CONSTRAINT PK_GARNISH PRIMARY KEY(ID)
);
------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE GARNISH_MIX (
	ID INT NOT NULL UNIQUE IDENTITY(1,1),
	GARNISH_ID INT NOT NULL DEFAULT(0),
	MIXED_DRINK_ID INT NOT NULL DEFAULT(0),
	MIXTURE VARCHAR(20),
		CONSTRAINT PK_GARNISH_MIX PRIMARY KEY(ID),
		CONSTRAINT FK_GARNISH_MIX_GARNISH_ID FOREIGN KEY(ID) REFERENCES GARNISH(ID),
		CONSTRAINT FK_GARNISH_MIX_MIXED_DRINK_ID FOREIGN KEY(MIXED_DRINK_ID) REFERENCES MIXED_DRINK(ID)
);
------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE LOCATION (
	ID INT NOT NULL UNIQUE IDENTITY(1,1),
	NAME VARCHAR(30),
	DESCRIPTION TEXT,
	STREET_NUMBER VARCHAR(10),
	STREET_NAME VARCHAR(50),
	EXTRA VARCHAR(30),
	CITY VARCHAR(20),
	STATE CHAR(2),
	ZIPCODE INT NOT NULL,
		CONSTRAINT PK_LOCATION PRIMARY KEY(ID),
		CONSTRAINT CHK_LOCATION_ZIPCODE CHECK(ZIPCODE BETWEEN 0 AND 99999)
);
------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE REVIEW_DRINK (
	ID INT NOT NULL UNIQUE IDENTITY(1,1),
	RATING INT NOT NULL DEFAULT(3),
	MIXED_DRINK_ID INT NOT NULL DEFAULT(0),
		CONSTRAINT PK_REVIEW_DRINK PRIMARY KEY(ID),
		CONSTRAINT CHK_REVIEW_DRINK_RATING CHECK(RATING BETWEEN 1 AND 5),
		CONSTRAINT FK_REVIEW_DRINK_MIXED_DRINK_ID FOREIGN KEY(MIXED_DRINK_ID) REFERENCES MIXED_DRINK(ID)
);
------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE REVIEW_LOCATION (
	ID INT NOT NULL UNIQUE IDENTITY(1,1),
	RATING INT NOT NULL DEFAULT(3),
	LOCATION_ID INT NOT NULL DEFAULT(0),
		CONSTRAINT PK_REVIEW_LOCATION PRIMARY KEY(ID),
		CONSTRAINT CHK_REVIEW_LOCATION_RATING CHECK(RATING BETWEEN 1 AND 5),
		CONSTRAINT FK_REVIEW_LOCATION_LOCATION_ID FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION(ID)
);
------------------------------------------------------------------------------------------------------------------------------------------