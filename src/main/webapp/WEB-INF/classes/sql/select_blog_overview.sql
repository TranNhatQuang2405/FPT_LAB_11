WITH tmp AS (
	SELECT 
		B.BLOG_ID,
		B.BLOG_NAME,
		CONVERT(VARCHAR(10), B.PUBLISHED_DATE, 34) AS PUBLISHED_DATE,
		(CAST(YEAR(B.PUBLISHED_DATE) AS VARCHAR(4)) + CAST(MONTH(B.PUBLISHED_DATE) AS VARCHAR(2))) AS MONTH_YEAR_INT,
		(UPPER(DATENAME(MONTH, B.PUBLISHED_DATE)) + ' ' + CAST(YEAR(B.PUBLISHED_DATE) AS VARCHAR(4))) AS MONTH_YEAR,
		ROW_NUMBER() OVER(ORDER BY B.PUBLISHED_DATE DESC, COALESCE(B.UPDATED_DATE_TIME, B.CREATED_DATE_TIME) DESC) AS ROW_ID
	FROM BLOG B
	WHERE B.ACTIVE_FLAG = 1
		AND B.DELETE_FLAG = 0
		AND B.USER_ID = ?
)
SELECT 
	A.MONTH_YEAR,
	CONCAT(
		'[',
			STRING_AGG(
				CONCAT('{"BLOG_ID" : "', A.BLOG_ID, 
				'", "BLOG_NAME": "', A.BLOG_NAME, 
				'", "PUBLISHED_DATE": "', A.PUBLISHED_DATE, 
				'", "ROW_ID": "', A.ROW_ID, '"}'), 
			','),
		']'
	) AS DATA
FROM tmp A
GROUP BY A.MONTH_YEAR, A.MONTH_YEAR_INT
ORDER BY A.MONTH_YEAR_INT DESC