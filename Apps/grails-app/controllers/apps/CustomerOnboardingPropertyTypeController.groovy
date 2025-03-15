package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CustomerOnboardingPropertyTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CustomerOnboardingPropertyType.list(params), model:[customerOnboardingPropertyTypeCount: CustomerOnboardingPropertyType.count()]
    }

    def show(CustomerOnboardingPropertyType customerOnboardingPropertyType) {
        respond customerOnboardingPropertyType
    }

    def create() {
        respond new CustomerOnboardingPropertyType(params)
    }

    @Transactional
    def save(CustomerOnboardingPropertyType customerOnboardingPropertyType) {
        if (customerOnboardingPropertyType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerOnboardingPropertyType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerOnboardingPropertyType.errors, view:'create'
            return
        }

        customerOnboardingPropertyType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerOnboardingPropertyType.label', default: 'CustomerOnboardingPropertyType'), customerOnboardingPropertyType.id])
                redirect customerOnboardingPropertyType
            }
            '*' { respond customerOnboardingPropertyType, [status: CREATED] }
        }
    }

    def edit(CustomerOnboardingPropertyType customerOnboardingPropertyType) {
        respond customerOnboardingPropertyType
    }

    @Transactional
    def update(CustomerOnboardingPropertyType customerOnboardingPropertyType) {
        if (customerOnboardingPropertyType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerOnboardingPropertyType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerOnboardingPropertyType.errors, view:'edit'
            return
        }

        customerOnboardingPropertyType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerOnboardingPropertyType.label', default: 'CustomerOnboardingPropertyType'), customerOnboardingPropertyType.id])
                redirect customerOnboardingPropertyType
            }
            '*'{ respond customerOnboardingPropertyType, [status: OK] }
        }
    }

    @Transactional
    def delete(CustomerOnboardingPropertyType customerOnboardingPropertyType) {

        if (customerOnboardingPropertyType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        customerOnboardingPropertyType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerOnboardingPropertyType.label', default: 'CustomerOnboardingPropertyType'), customerOnboardingPropertyType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerOnboardingPropertyType.label', default: 'CustomerOnboardingPropertyType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
