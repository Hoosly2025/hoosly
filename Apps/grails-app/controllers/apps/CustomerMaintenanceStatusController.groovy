package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CustomerMaintenanceStatusController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CustomerMaintenanceStatus.list(params), model:[customerMaintenanceStatusCount: CustomerMaintenanceStatus.count()]
    }

    def show(CustomerMaintenanceStatus customerMaintenanceStatus) {
        respond customerMaintenanceStatus
    }

    def create() {
        respond new CustomerMaintenanceStatus(params)
    }

    @Transactional
    def save(CustomerMaintenanceStatus customerMaintenanceStatus) {
        if (customerMaintenanceStatus == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerMaintenanceStatus.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerMaintenanceStatus.errors, view:'create'
            return
        }

        customerMaintenanceStatus.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerMaintenanceStatus.label', default: 'CustomerMaintenanceStatus'), customerMaintenanceStatus.id])
                redirect customerMaintenanceStatus
            }
            '*' { respond customerMaintenanceStatus, [status: CREATED] }
        }
    }

    def edit(CustomerMaintenanceStatus customerMaintenanceStatus) {
        respond customerMaintenanceStatus
    }

    @Transactional
    def update(CustomerMaintenanceStatus customerMaintenanceStatus) {
        if (customerMaintenanceStatus == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerMaintenanceStatus.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerMaintenanceStatus.errors, view:'edit'
            return
        }

        customerMaintenanceStatus.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerMaintenanceStatus.label', default: 'CustomerMaintenanceStatus'), customerMaintenanceStatus.id])
                redirect customerMaintenanceStatus
            }
            '*'{ respond customerMaintenanceStatus, [status: OK] }
        }
    }

    @Transactional
    def delete(CustomerMaintenanceStatus customerMaintenanceStatus) {

        if (customerMaintenanceStatus == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        customerMaintenanceStatus.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerMaintenanceStatus.label', default: 'CustomerMaintenanceStatus'), customerMaintenanceStatus.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerMaintenanceStatus.label', default: 'CustomerMaintenanceStatus'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
