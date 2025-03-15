package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CustomerOnboardingServiceInterestsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CustomerOnboardingServiceInterests.list(params), model:[customerOnboardingServiceInterestsCount: CustomerOnboardingServiceInterests.count()]
    }

    def show(CustomerOnboardingServiceInterests customerOnboardingServiceInterests) {
        respond customerOnboardingServiceInterests
    }

    def create() {
        respond new CustomerOnboardingServiceInterests(params)
    }

    @Transactional
    def save(CustomerOnboardingServiceInterests customerOnboardingServiceInterests) {
        if (customerOnboardingServiceInterests == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerOnboardingServiceInterests.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerOnboardingServiceInterests.errors, view:'create'
            return
        }

        customerOnboardingServiceInterests.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerOnboardingServiceInterests.label', default: 'CustomerOnboardingServiceInterests'), customerOnboardingServiceInterests.id])
                redirect customerOnboardingServiceInterests
            }
            '*' { respond customerOnboardingServiceInterests, [status: CREATED] }
        }
    }

    def edit(CustomerOnboardingServiceInterests customerOnboardingServiceInterests) {
        respond customerOnboardingServiceInterests
    }

    @Transactional
    def update(CustomerOnboardingServiceInterests customerOnboardingServiceInterests) {
        if (customerOnboardingServiceInterests == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerOnboardingServiceInterests.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerOnboardingServiceInterests.errors, view:'edit'
            return
        }

        customerOnboardingServiceInterests.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerOnboardingServiceInterests.label', default: 'CustomerOnboardingServiceInterests'), customerOnboardingServiceInterests.id])
                redirect customerOnboardingServiceInterests
            }
            '*'{ respond customerOnboardingServiceInterests, [status: OK] }
        }
    }

    @Transactional
    def delete(CustomerOnboardingServiceInterests customerOnboardingServiceInterests) {

        if (customerOnboardingServiceInterests == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        customerOnboardingServiceInterests.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerOnboardingServiceInterests.label', default: 'CustomerOnboardingServiceInterests'), customerOnboardingServiceInterests.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerOnboardingServiceInterests.label', default: 'CustomerOnboardingServiceInterests'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
