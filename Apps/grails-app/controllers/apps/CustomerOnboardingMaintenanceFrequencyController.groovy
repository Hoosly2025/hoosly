package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CustomerOnboardingMaintenanceFrequencyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CustomerOnboardingMaintenanceFrequency.list(params), model:[customerOnboardingMaintenanceFrequencyCount: CustomerOnboardingMaintenanceFrequency.count()]
    }

    def show(CustomerOnboardingMaintenanceFrequency customerOnboardingMaintenanceFrequency) {
        respond customerOnboardingMaintenanceFrequency
    }

    def create() {
        respond new CustomerOnboardingMaintenanceFrequency(params)
    }

    @Transactional
    def save(CustomerOnboardingMaintenanceFrequency customerOnboardingMaintenanceFrequency) {
        if (customerOnboardingMaintenanceFrequency == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerOnboardingMaintenanceFrequency.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerOnboardingMaintenanceFrequency.errors, view:'create'
            return
        }

        customerOnboardingMaintenanceFrequency.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerOnboardingMaintenanceFrequency.label', default: 'CustomerOnboardingMaintenanceFrequency'), customerOnboardingMaintenanceFrequency.id])
                redirect customerOnboardingMaintenanceFrequency
            }
            '*' { respond customerOnboardingMaintenanceFrequency, [status: CREATED] }
        }
    }

    def edit(CustomerOnboardingMaintenanceFrequency customerOnboardingMaintenanceFrequency) {
        respond customerOnboardingMaintenanceFrequency
    }

    @Transactional
    def update(CustomerOnboardingMaintenanceFrequency customerOnboardingMaintenanceFrequency) {
        if (customerOnboardingMaintenanceFrequency == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerOnboardingMaintenanceFrequency.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerOnboardingMaintenanceFrequency.errors, view:'edit'
            return
        }

        customerOnboardingMaintenanceFrequency.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerOnboardingMaintenanceFrequency.label', default: 'CustomerOnboardingMaintenanceFrequency'), customerOnboardingMaintenanceFrequency.id])
                redirect customerOnboardingMaintenanceFrequency
            }
            '*'{ respond customerOnboardingMaintenanceFrequency, [status: OK] }
        }
    }

    @Transactional
    def delete(CustomerOnboardingMaintenanceFrequency customerOnboardingMaintenanceFrequency) {

        if (customerOnboardingMaintenanceFrequency == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        customerOnboardingMaintenanceFrequency.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerOnboardingMaintenanceFrequency.label', default: 'CustomerOnboardingMaintenanceFrequency'), customerOnboardingMaintenanceFrequency.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerOnboardingMaintenanceFrequency.label', default: 'CustomerOnboardingMaintenanceFrequency'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
