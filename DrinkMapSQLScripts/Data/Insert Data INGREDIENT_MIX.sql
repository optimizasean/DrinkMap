------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Long Island Iced Tea'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Gin'), 1.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Long Island Iced Tea'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Tequila'), 1.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Long Island Iced Tea'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Vodka'), 1.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Long Island Iced Tea'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'White rum'), 1.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Long Island Iced Tea'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Triple sec'), 1.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Long Island Iced Tea'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Gomme syrup'), 3, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Long Island Iced Tea'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Lemon juice'), 2.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Long Island Iced Tea'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Cola'), 1 'dash');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Adios Mother Fucker'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Vodka'), 1.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Adios Mother Fucker'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Gin'), 1.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Adios Mother Fucker'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'White rum'), 1.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Adios Mother Fucker'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Triple sec'), 1.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Adios Mother Fucker'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Blue curacao'), 1, 'dash');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Alexander'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Cognac'), 3, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Alexander'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Créme de cacao (brown)'), 3, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Alexander'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Fresh cream'), 3, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Americano'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Campari'), 3, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Americano'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Red Vermouth'), 3, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Americano'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Soda wate'), 1, 'splash');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Angel Face'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Calvados'), 3, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Angel Face'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Gin'), 3, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Angel Face'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Apricot brandy'), 3, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Aviation'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Gin'), 4.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Aviation'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Maraschino'), 1.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Aviation'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Lemon juice'), 1.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Barcadi'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Barcadi carta blanca'), 4.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Barcadi'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Lime juice'), 2, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Barcadi'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Grenadine'), 1, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Barracuda'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Gold rum'), 4.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Barracuda'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Galliano'), 1.5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Barracuda'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Pineapple juice'), 6, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Barracuda'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Lime juice'), 1, 'dash');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Barracuda'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Prosecco'), 1, 'dash');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Bellini'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Prosecco'), 10, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Bellini'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Peach puree'), 5, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Bellini'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Sparkling wine'), 1, 'dash');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Between The Sheets'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Cognac'), 3, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Between The Sheets'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'White rum'), 3, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Between The Sheets'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Triple sec'), 3, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Between The Sheets'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Lemon juice'), 2, 'cl');

INSERT INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Black Russian'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Vodka'), 5, 'cl');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Black Russian'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Coffee liqueur'), 2, 'cl');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Blue Hawaiian'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Coconut rum'), 2, 'cl');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Blue Hawaiian'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Roses blue curacao'), 2, 'cl');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Blue Hawaiian'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Pineapple juice'), 6, 'cl');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Blue Hawaiian'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Sparkling water'), 2, 'cl');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Bloody Mary'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Vodka'), 4.5, 'cl');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Bloody Mary'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Tomato juice'), 9, 'cl');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Bloody Mary'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Lemon juice'), 1.5, 'cl');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Bloody Mary'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Worcesershire sause'), 3, 'dash');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Bloody Mary'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Tabasco'), 1, 'dash');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Bramble'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Gin'), 4, 'cl');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Bramble'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Simple syrup'), 1, 'cl');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Bramble'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Lemon juice'), 1.5, 'cl');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Bramble'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Blackberry liqueur'), 1.5, 'cl');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Brave bull'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Tequila'), 4.5, 'cl');

INTO INGREDIENT_MIX(INGREDIENT_ID, MIXED_DRINK_ID, RATIO, UNIT)
	VALUES((SELECT ID FROM INGREDIENT WHERE NAME = 'Brave bull'), (SELECT ID FROM MIXED_DRINK WHERE NAME = 'Gin'), 3, 'cl');

------------------------------------------------------------------------------------------------------------------------------------------