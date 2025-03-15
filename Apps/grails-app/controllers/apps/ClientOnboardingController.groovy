package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ClientOnboardingController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ClientOnboarding.list(params), model:[clientOnboardingCount: ClientOnboarding.count()]
    }

    def show(ClientOnboarding clientOnboarding) {
        respond clientOnboarding
    }

    def create() {
        respond new ClientOnboarding(params)
    }

    @Transactional
    def save(ClientOnboarding clientOnboarding) {
        if (clientOnboarding == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (clientOnboarding.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond clientOnboarding.errors, view:'create'
            return
        }

        clientOnboarding.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'clientOnboarding.label', default: 'ClientOnboarding'), clientOnboarding.id])
                redirect clientOnboarding
            }
            '*' { respond clientOnboarding, [status: CREATED] }
        }
    }

    def edit(ClientOnboarding clientOnboarding) {
        respond clientOnboarding
    }

    @Transactional
    def update(ClientOnboarding clientOnboarding) {
        if (clientOnboarding == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (clientOnboarding.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond clientOnboarding.errors, view:'edit'
            return
        }

        clientOnboarding.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'clientOnboarding.label', default: 'ClientOnboarding'), clientOnboarding.id])
                redirect clientOnboarding
            }
            '*'{ respond clientOnboarding, [status: OK] }
        }
    }

    @Transactional
    def delete(ClientOnboarding clientOnboarding) {

        if (clientOnboarding == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        clientOnboarding.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'clientOnboarding.label', default: 'ClientOnboarding'), clientOnboarding.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'clientOnboarding.label', default: 'ClientOnboarding'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
