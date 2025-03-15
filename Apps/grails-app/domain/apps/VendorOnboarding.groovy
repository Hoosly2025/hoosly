package apps

class VendorOnboarding {

    String companyName
    String primaryContactName
    String primaryContactEmail
    String primaryContactPhone
    String businessStreetAddress
    String businessCity
    String businessState
    String businessZipCode
    
    //TODO: services could be a set of checkboxes
    String services
    
    //TODO: categories could map to a category table with parent ID for parent categories
    String categories
    
    //TODO: Could be a set of checkboxes, based on city / state, multiple cities, areas
    String serviceArea
    
    //licensing
    String certificationsLicensing
    Date createTime
	Date updateTime
        
    static constraints = {
		companyName(nullable:false, maxSize:100)
        primaryContactName(nullable:false, maxSize:500)
        primaryContactEmail(nullable:false, maxSize:100)
        primaryContactPhone(nullable:false, maxSize:50)
        businessStreetAddress(nullable:false, maxSize:100)
        businessCity(nullable:false, maxSize:50)
        businessState(nullable:false, maxSize:50)
        businessZipCode(nullable:false, maxSize:50)
        services(nullable:false, maxSize:500)
        categories(nullable:false, maxSize:500)
        serviceArea(nullable:false, maxSize:500)
        certificationsLicensing(nullable:false, maxSize:1000)
        createTime(nullable:false)
        updateTime(nullable:false)
    }
    
    static mapping = {
    	version false
    }
}
