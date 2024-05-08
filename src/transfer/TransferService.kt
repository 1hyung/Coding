package transfer

import jdk.jfr.DataAmount

class TransferService {

    private val bankAccounts = listOf<BankAccount>(
        BankAccount(address = "abc", balance = 100, userId = 'a'),
        BankAccount(address = "abcd", balance = 200, userId = 'b')
    )

    fun transfer(request: TransferRequest): TransferResponse {
        //보내는 금액 확인
        if (request.amount < 0) {
            return TransferResponse(success = false, message = "Invalid amount")
        }

        // 보내는 주소, 받는 주소를 확인
        if (!isValidAddress(request.fromAddress) || !isValidAddress(request.toAddress)) {
            return TransferResponse(success = false, message = "Invalid address")
        }

        // 잔액 체크
        val senderAccount = getBankAccountByAddress(request.fromAddress)
        if (isSufficientBalance(senderAccount, request.amount)) {
            return TransferResponse(success = false, message = "No sufficient balance")
        }

        val receiverAccount = getBankAccountByAddress(request.toAddress)
        senderAccount.balance = senderAccount.balance - request.amount
        receiverAccount.balance += request.amount

        return TransferResponse(success = true, message = "Succeeded!!!")

    }

    private fun isValidAddress(address: String): Boolean {
        bankAccounts.any { it.address == address }
    }

    private fun isSufficientBalance(bankAccount: BankAccount, amount: Int): Boolean {
        return bankAccount.balance >= amount
    }

    private fun getBankAccountByAddress(address: String) {
        return bankAccounts.first { it.address == address }
    }
}


