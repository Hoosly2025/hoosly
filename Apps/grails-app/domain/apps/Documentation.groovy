package apps

class Documentation {

    //Long id
        Date createTime
        String name
        String description
        Date updateTime

    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:false)
    }
}
