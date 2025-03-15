package apps

class VendorSubscription {
	
	VendorOnboarding vendorOnboarding

	//TODO: current plan type could be a drop down
    VendorSubscriptionCurrentPlanType currentPlanType
    Date subscriptionStart
	Date renewal
	String paymentMethod
	Date lastPayment
	Date nextBilling
	
    static constraints = {
		vendorOnboarding(nullable:true)
	    currentPlanType(nullable:false)
        subscriptionStart(nullable:false)
        renewal(nullable:false)	
		paymentMethod(nullable:false, maxSize:100)
        lastPayment(nullable:false)
        nextBilling(nullable:false)
    }
    
    static mapping = {
    	version false
    }
}
