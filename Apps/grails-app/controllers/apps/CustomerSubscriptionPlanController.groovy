package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CustomerSubscriptionPlanController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CustomerSubscriptionPlan.list(params), model:[customerSubscriptionPlanCount: CustomerSubscriptionPlan.count()]
    }

    def show(CustomerSubscriptionPlan customerSubscriptionPlan) {
        respond customerSubscriptionPlan
    }

    def create() {
        respond new CustomerSubscriptionPlan(params)
    }

    @Transactional
    def save(CustomerSubscriptionPlan customerSubscriptionPlan) {
        if (customerSubscriptionPlan == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerSubscriptionPlan.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerSubscriptionPlan.errors, view:'create'
            return
        }

        customerSubscriptionPlan.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerSubscriptionPlan.label', default: 'CustomerSubscriptionPlan'), customerSubscriptionPlan.id])
                redirect customerSubscriptionPlan
            }
            '*' { respond customerSubscriptionPlan, [status: CREATED] }
        }
    }

    def edit(CustomerSubscriptionPlan customerSubscriptionPlan) {
        respond customerSubscriptionPlan
    }

    @Transactional
    def update(CustomerSubscriptionPlan customerSubscriptionPlan) {
        if (customerSubscriptionPlan == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerSubscriptionPlan.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerSubscriptionPlan.errors, view:'edit'
            return
        }

        customerSubscriptionPlan.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerSubscriptionPlan.label', default: 'CustomerSubscriptionPlan'), customerSubscriptionPlan.id])
                redirect customerSubscriptionPlan
            }
            '*'{ respond customerSubscriptionPlan, [status: OK] }
        }
    }

    @Transactional
    def delete(CustomerSubscriptionPlan customerSubscriptionPlan) {

        if (customerSubscriptionPlan == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        customerSubscriptionPlan.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerSubscriptionPlan.label', default: 'CustomerSubscriptionPlan'), customerSubscriptionPlan.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerSubscriptionPlan.label', default: 'CustomerSubscriptionPlan'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
