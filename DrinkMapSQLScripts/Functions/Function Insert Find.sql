------------------------------------------------------------------------------------------------------------------------------------------
---------------------------FIND GARNISH ID FROM NAME
CREATE FUNCTION GARNISH_ID(@GARNISH_NAME VARCHAR(MAX))
RETURNS INT
AS
BEGIN
	DECLARE @ret INT
	SET @ret = (SELECT ID FROM GARNISH WHERE NAME = @GARNISH_NAME);
	IF (@ret IS NULL)
		SET @ret = 0;
	RETURN @ret;
END;
------------------------------------------------------------------------------------------------------------------------------------------
---------------------------FIND MIXED_DRINK ID FROM NAME
CREATE FUNCTION MIXED_DRINK_ID(@MIXED_DRINK_NAME VARCHAR(MAX))
RETURNS INT
AS
BEGIN
	DECLARE @ret INT
	SET @ret = (SELECT ID FROM MIXED_DRINK WHERE NAME = @MIXED_DRINK_NAME);
	IF (@ret IS NULL)
		SET @ret = 0;
	RETURN @ret;
END;
------------------------------------------------------------------------------------------------------------------------------------------
---------------------------FIND INGREDIENT_TYPE ID FROM NAME
CREATE FUNCTION INGREDIENT_TYPE_ID(@INGREDIENT_TYPE_CATEGORY VARCHAR(MAX))
RETURNS INT
AS
BEGIN
	DECLARE @ret INT
	SET @ret = (SELECT ID FROM INGREDIENT_TYPE WHERE CATEGORY = @INGREDIENT_TYPE_CATEGORY);
	IF (@ret IS NULL)
		SET @ret = 0;
	RETURN @ret;
END;
------------------------------------------------------------------------------------------------------------------------------------------
---------------------------FIND BRAND ID FROM NAME
CREATE FUNCTION BRAND_ID(@BRAND_NAME VARCHAR(MAX))
RETURNS INT
AS
BEGIN
	DECLARE @ret INT
	SET @ret = (SELECT ID FROM BRAND WHERE NAME = @BRAND_NAME);
	IF (@ret IS NULL)
		SET @ret = 0;
	RETURN @ret;
END;
------------------------------------------------------------------------------------------------------------------------------------------
---------------------------FIND INGREDIENT ID FROM NAME
CREATE FUNCTION INGREDIENT_ID(@INGREDIENT_NAME VARCHAR(MAX))
RETURNS INT
AS
BEGIN
	DECLARE @ret INT
	SET @ret = (SELECT ID FROM INGREDIENT WHERE NAME = @INGREDIENT_NAME);
	IF (@ret IS NULL)
		SET @ret = 0;
	RETURN @ret;
END;
------------------------------------------------------------------------------------------------------------------------------------------
---------------------------FIND GLASSWARE ID FROM NAME
CREATE FUNCTION GLASSWARE_ID(@GLASSWARE_ID VARCHAR(MAX))
RETURNS INT
AS
BEGIN
	DECLARE @ret INT
	SET @ret = (SELECT ID FROM GLASSWARE WHERE NAME = @GLASSWARE_ID);
	IF (@ret IS NULL)
		SET @ret = 0;
	RETURN @ret;
END;
------------------------------------------------------------------------------------------------------------------------------------------