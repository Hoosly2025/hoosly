package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ClientSubscriptionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ClientSubscription.list(params), model:[clientSubscriptionCount: ClientSubscription.count()]
    }

    def show(ClientSubscription clientSubscription) {
        respond clientSubscription
    }

    def create() {
        respond new ClientSubscription(params)
    }

    @Transactional
    def save(ClientSubscription clientSubscription) {
        if (clientSubscription == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (clientSubscription.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond clientSubscription.errors, view:'create'
            return
        }

        clientSubscription.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'clientSubscription.label', default: 'ClientSubscription'), clientSubscription.id])
                redirect clientSubscription
            }
            '*' { respond clientSubscription, [status: CREATED] }
        }
    }

    def edit(ClientSubscription clientSubscription) {
        respond clientSubscription
    }

    @Transactional
    def update(ClientSubscription clientSubscription) {
        if (clientSubscription == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (clientSubscription.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond clientSubscription.errors, view:'edit'
            return
        }

        clientSubscription.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'clientSubscription.label', default: 'ClientSubscription'), clientSubscription.id])
                redirect clientSubscription
            }
            '*'{ respond clientSubscription, [status: OK] }
        }
    }

    @Transactional
    def delete(ClientSubscription clientSubscription) {

        if (clientSubscription == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        clientSubscription.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'clientSubscription.label', default: 'ClientSubscription'), clientSubscription.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'clientSubscription.label', default: 'ClientSubscription'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
