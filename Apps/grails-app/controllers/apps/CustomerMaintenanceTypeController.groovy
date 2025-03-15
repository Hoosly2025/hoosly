package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CustomerMaintenanceTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CustomerMaintenanceType.list(params), model:[customerMaintenanceTypeCount: CustomerMaintenanceType.count()]
    }

    def show(CustomerMaintenanceType customerMaintenanceType) {
        respond customerMaintenanceType
    }

    def create() {
        respond new CustomerMaintenanceType(params)
    }

    @Transactional
    def save(CustomerMaintenanceType customerMaintenanceType) {
        if (customerMaintenanceType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerMaintenanceType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerMaintenanceType.errors, view:'create'
            return
        }

        customerMaintenanceType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerMaintenanceType.label', default: 'CustomerMaintenanceType'), customerMaintenanceType.id])
                redirect customerMaintenanceType
            }
            '*' { respond customerMaintenanceType, [status: CREATED] }
        }
    }

    def edit(CustomerMaintenanceType customerMaintenanceType) {
        respond customerMaintenanceType
    }

    @Transactional
    def update(CustomerMaintenanceType customerMaintenanceType) {
        if (customerMaintenanceType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerMaintenanceType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerMaintenanceType.errors, view:'edit'
            return
        }

        customerMaintenanceType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerMaintenanceType.label', default: 'CustomerMaintenanceType'), customerMaintenanceType.id])
                redirect customerMaintenanceType
            }
            '*'{ respond customerMaintenanceType, [status: OK] }
        }
    }

    @Transactional
    def delete(CustomerMaintenanceType customerMaintenanceType) {

        if (customerMaintenanceType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        customerMaintenanceType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerMaintenanceType.label', default: 'CustomerMaintenanceType'), customerMaintenanceType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerMaintenanceType.label', default: 'CustomerMaintenanceType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
