package apps

class CustomerOnboardingServiceInterestsMap {

	ClientOnboarding customerOnboarding
	CustomerOnboardingServiceInterests customerOnboardingServiceInterests
	
    static constraints = {
		customerOnboarding(nullable:false)
		customerOnboardingServiceInterests(nullable:false)
    }
    
    static mapping = {
    	version false
    }
}
