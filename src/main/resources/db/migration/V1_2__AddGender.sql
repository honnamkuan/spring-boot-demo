ALTER TABLE USER_TABLE ADD COLUMN (GENDER VARCHAR(1));

UPDATE user_table
SET gender = 'M';

PREPARE stmt1 FROM 'UPDATE user_table set gender = ''F'' where (full_name like ''R%'') AND ? > 0';

SET @updateCount = (SELECT count(*)
                    FROM user_table
                    WHERE (full_name = 'Reddy' OR full_name LIKE 'P%') AND gender = 'M');

EXECUTE stmt1
USING @updateCount;

DEALLOCATE PREPARE stmt1;
