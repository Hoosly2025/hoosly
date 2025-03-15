package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CustomerSubscriptionCurrentPlanTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CustomerSubscriptionCurrentPlanType.list(params), model:[customerSubscriptionCurrentPlanTypeCount: CustomerSubscriptionCurrentPlanType.count()]
    }

    def show(CustomerSubscriptionCurrentPlanType customerSubscriptionCurrentPlanType) {
        respond customerSubscriptionCurrentPlanType
    }

    def create() {
        respond new CustomerSubscriptionCurrentPlanType(params)
    }

    @Transactional
    def save(CustomerSubscriptionCurrentPlanType customerSubscriptionCurrentPlanType) {
        if (customerSubscriptionCurrentPlanType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerSubscriptionCurrentPlanType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerSubscriptionCurrentPlanType.errors, view:'create'
            return
        }

        customerSubscriptionCurrentPlanType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerSubscriptionCurrentPlanType.label', default: 'CustomerSubscriptionCurrentPlanType'), customerSubscriptionCurrentPlanType.id])
                redirect customerSubscriptionCurrentPlanType
            }
            '*' { respond customerSubscriptionCurrentPlanType, [status: CREATED] }
        }
    }

    def edit(CustomerSubscriptionCurrentPlanType customerSubscriptionCurrentPlanType) {
        respond customerSubscriptionCurrentPlanType
    }

    @Transactional
    def update(CustomerSubscriptionCurrentPlanType customerSubscriptionCurrentPlanType) {
        if (customerSubscriptionCurrentPlanType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerSubscriptionCurrentPlanType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerSubscriptionCurrentPlanType.errors, view:'edit'
            return
        }

        customerSubscriptionCurrentPlanType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerSubscriptionCurrentPlanType.label', default: 'CustomerSubscriptionCurrentPlanType'), customerSubscriptionCurrentPlanType.id])
                redirect customerSubscriptionCurrentPlanType
            }
            '*'{ respond customerSubscriptionCurrentPlanType, [status: OK] }
        }
    }

    @Transactional
    def delete(CustomerSubscriptionCurrentPlanType customerSubscriptionCurrentPlanType) {

        if (customerSubscriptionCurrentPlanType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        customerSubscriptionCurrentPlanType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerSubscriptionCurrentPlanType.label', default: 'CustomerSubscriptionCurrentPlanType'), customerSubscriptionCurrentPlanType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerSubscriptionCurrentPlanType.label', default: 'CustomerSubscriptionCurrentPlanType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
