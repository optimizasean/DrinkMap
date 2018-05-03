------------------------------------------------------------------------------------------------------------------------------------------
---------------------------FIND GARNISH ID FROM NAME
CREATE FUNCTION FUNCTION_GARNISH_ID(@GARNISH_NAME VARCHAR(MAX))
RETURNS INT
AS
BEGIN
	DECLARE @ret INT
	SET @ret = (SELECT ID FROM GARNISH WHERE NAME = @GARNISH_NAME);
	IF (@ret IS NULL)
		SET @ret = 0;
	RETURN @ret;
END;
GO
------------------------------------------------------------------------------------------------------------------------------------------
---------------------------FIND MIXED_DRINK ID FROM NAME
CREATE FUNCTION FUNCTION_MIXED_DRINK_ID(@MIXED_DRINK_NAME VARCHAR(MAX))
RETURNS INT
AS
BEGIN
	DECLARE @ret INT
	SET @ret = (SELECT ID FROM MIXED_DRINK WHERE NAME = @MIXED_DRINK_NAME);
	IF (@ret IS NULL)
		SET @ret = 0;
	RETURN @ret;
END;
GO
------------------------------------------------------------------------------------------------------------------------------------------
---------------------------FIND INGREDIENT_TYPE ID FROM NAME
CREATE FUNCTION FUNCTION_INGREDIENT_TYPE_ID(@INGREDIENT_TYPE_CATEGORY VARCHAR(MAX))
RETURNS INT
AS
BEGIN
	DECLARE @ret INT
	SET @ret = (SELECT ID FROM INGREDIENT_TYPE WHERE CATEGORY = @INGREDIENT_TYPE_CATEGORY);
	IF (@ret IS NULL)
		SET @ret = 0;
	RETURN @ret;
END;
GO
------------------------------------------------------------------------------------------------------------------------------------------
---------------------------FIND BRAND ID FROM NAME
CREATE FUNCTION FUNCTION_BRAND_ID(@BRAND_NAME VARCHAR(MAX))
RETURNS INT
AS
BEGIN
	DECLARE @ret INT
	SET @ret = (SELECT ID FROM BRAND WHERE NAME = @BRAND_NAME);
	IF (@ret IS NULL)
		SET @ret = 0;
	RETURN @ret;
END;
GO
------------------------------------------------------------------------------------------------------------------------------------------
---------------------------FIND INGREDIENT ID FROM NAME
CREATE FUNCTION FUNCTION_INGREDIENT_ID(@INGREDIENT_NAME VARCHAR(MAX))
RETURNS INT
AS
BEGIN
	DECLARE @ret INT
	SET @ret = (SELECT ID FROM INGREDIENT WHERE NAME = @INGREDIENT_NAME);
	IF (@ret IS NULL)
		SET @ret = 0;
	RETURN @ret;
END;
GO
------------------------------------------------------------------------------------------------------------------------------------------
---------------------------FIND GLASSWARE ID FROM NAME
CREATE FUNCTION FUNCTION_GLASSWARE_ID(@GLASSWARE_NAME VARCHAR(MAX))
RETURNS INT
AS
BEGIN
	DECLARE @ret INT
	SET @ret = (SELECT ID FROM GLASSWARE WHERE NAME = @GLASSWARE_NAME);
	IF (@ret IS NULL)
		SET @ret = 0;
	RETURN @ret;
END;
GO
------------------------------------------------------------------------------------------------------------------------------------------
---------------------------FIND LOCATION ID FROM NAME
CREATE FUNCTION FUNCTION_LOCATION_ID(@LOCATION_NAME VARCHAR(MAX))
RETURNS INT
AS
BEGIN
	DECLARE @ret INT
	SET @ret = (SELECT ID FROM GLASSWARE WHERE NAME = @LOCATION_NAME);
	IF (@ret IS NULL)
		SET @ret = 0;
	RETURN @ret;
END;
GO
------------------------------------------------------------------------------------------------------------------------------------------