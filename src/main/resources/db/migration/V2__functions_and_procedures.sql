CREATE OR REPLACE FUNCTION count_animals_by_category(cat VARCHAR)
RETURNS INTEGER
LANGUAGE plpgsql
AS
$$
DECLARE
    cnt INTEGER;
BEGIN
    SELECT COUNT(*) INTO cnt
    FROM animals
    WHERE category = cat;

    RETURN cnt;
END;
$$;

CREATE OR REPLACE PROCEDURE uppercase_animal_name_for_category(cat VARCHAR)
LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE animals
    SET name = UPPER(name)
    WHERE category = cat;
END;
$$;