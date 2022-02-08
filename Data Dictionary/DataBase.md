大家看看表怎么设计
前台：
Client(**id**,user_name,password) 用户
Course(**id**,course_name,teacher,price,content) 课程信息
Teach(**id**,course_id,student_id,teacher_id) 授课-学习
Teacher(**id**,teacher_name) 老师

后台：
Admin(**id**,user_name,password) 管理员
Order(**id**,client_id,course_id,price) 订单
BlockedWord(**id**,text) 屏蔽词
BlockedUser(**id**,user_id) 被禁用户
BlockedComments(**id**,client_id,text) 被禁的评论
Assessor(**id**,user_name) 审核员


