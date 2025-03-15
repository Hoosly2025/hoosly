package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CustomerOnboardingServiceInterestsMapController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CustomerOnboardingServiceInterestsMap.list(params), model:[customerOnboardingServiceInterestsMapCount: CustomerOnboardingServiceInterestsMap.count()]
    }

    def show(CustomerOnboardingServiceInterestsMap customerOnboardingServiceInterestsMap) {
        respond customerOnboardingServiceInterestsMap
    }

    def create() {
        respond new CustomerOnboardingServiceInterestsMap(params)
    }

    @Transactional
    def save(CustomerOnboardingServiceInterestsMap customerOnboardingServiceInterestsMap) {
        if (customerOnboardingServiceInterestsMap == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerOnboardingServiceInterestsMap.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerOnboardingServiceInterestsMap.errors, view:'create'
            return
        }

        customerOnboardingServiceInterestsMap.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerOnboardingServiceInterestsMap.label', default: 'CustomerOnboardingServiceInterestsMap'), customerOnboardingServiceInterestsMap.id])
                redirect customerOnboardingServiceInterestsMap
            }
            '*' { respond customerOnboardingServiceInterestsMap, [status: CREATED] }
        }
    }

    def edit(CustomerOnboardingServiceInterestsMap customerOnboardingServiceInterestsMap) {
        respond customerOnboardingServiceInterestsMap
    }

    @Transactional
    def update(CustomerOnboardingServiceInterestsMap customerOnboardingServiceInterestsMap) {
        if (customerOnboardingServiceInterestsMap == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerOnboardingServiceInterestsMap.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerOnboardingServiceInterestsMap.errors, view:'edit'
            return
        }

        customerOnboardingServiceInterestsMap.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerOnboardingServiceInterestsMap.label', default: 'CustomerOnboardingServiceInterestsMap'), customerOnboardingServiceInterestsMap.id])
                redirect customerOnboardingServiceInterestsMap
            }
            '*'{ respond customerOnboardingServiceInterestsMap, [status: OK] }
        }
    }

    @Transactional
    def delete(CustomerOnboardingServiceInterestsMap customerOnboardingServiceInterestsMap) {

        if (customerOnboardingServiceInterestsMap == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        customerOnboardingServiceInterestsMap.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerOnboardingServiceInterestsMap.label', default: 'CustomerOnboardingServiceInterestsMap'), customerOnboardingServiceInterestsMap.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerOnboardingServiceInterestsMap.label', default: 'CustomerOnboardingServiceInterestsMap'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
