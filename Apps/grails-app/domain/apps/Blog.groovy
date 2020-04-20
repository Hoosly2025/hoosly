package apps

class Blog {

    //Long id
	Date createTime
	String name
	String description
	Date updateTime
    User user
	byte[] imageOne
	byte[] imageTwo
	byte[] imageThree
	BlogCategory blogCategory

    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:false)
                user(nullable:false)
				imageOne(nullable:true, maxSize: 1024 * 1024 * 2)
				imageTwo(nullable:true, maxSize: 1024 * 1024 * 2)
				imageThree(nullable:true, maxSize: 1024 * 1024 * 2)
				blogCategory(nullable:true)
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
