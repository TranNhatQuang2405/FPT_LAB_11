SELECT 
	B.BLOG_ID,
	B.BLOG_NAME,
	B.BLOG_CONTENT,
	B.IMAGE_URL,
	B.ICON_CLASS,
	CONVERT(VARCHAR(10), B.PUBLISHED_DATE, 34) AS PUBLISHED_DATE
FROM BLOG B
WHERE B.DELETE_FLAG = 0
	AND B.ACTIVE_FLAG = 1
	AND B.USER_ID = ?
	AND B.BLOG_ID = ?