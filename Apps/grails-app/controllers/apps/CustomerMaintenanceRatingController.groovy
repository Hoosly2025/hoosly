package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CustomerMaintenanceRatingController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CustomerMaintenanceRating.list(params), model:[customerMaintenanceRatingCount: CustomerMaintenanceRating.count()]
    }

    def show(CustomerMaintenanceRating customerMaintenanceRating) {
        respond customerMaintenanceRating
    }

    def create() {
        respond new CustomerMaintenanceRating(params)
    }

    @Transactional
    def save(CustomerMaintenanceRating customerMaintenanceRating) {
        if (customerMaintenanceRating == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerMaintenanceRating.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerMaintenanceRating.errors, view:'create'
            return
        }

        customerMaintenanceRating.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerMaintenanceRating.label', default: 'CustomerMaintenanceRating'), customerMaintenanceRating.id])
                redirect customerMaintenanceRating
            }
            '*' { respond customerMaintenanceRating, [status: CREATED] }
        }
    }

    def edit(CustomerMaintenanceRating customerMaintenanceRating) {
        respond customerMaintenanceRating
    }

    @Transactional
    def update(CustomerMaintenanceRating customerMaintenanceRating) {
        if (customerMaintenanceRating == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerMaintenanceRating.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerMaintenanceRating.errors, view:'edit'
            return
        }

        customerMaintenanceRating.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerMaintenanceRating.label', default: 'CustomerMaintenanceRating'), customerMaintenanceRating.id])
                redirect customerMaintenanceRating
            }
            '*'{ respond customerMaintenanceRating, [status: OK] }
        }
    }

    @Transactional
    def delete(CustomerMaintenanceRating customerMaintenanceRating) {

        if (customerMaintenanceRating == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        customerMaintenanceRating.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerMaintenanceRating.label', default: 'CustomerMaintenanceRating'), customerMaintenanceRating.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerMaintenanceRating.label', default: 'CustomerMaintenanceRating'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
