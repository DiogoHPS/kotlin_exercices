interface Notificacao{
    public notificarUsuario(mensagem:String)
}

class NotificacaoEmail : Notificacao{
    override fun notificarUsuario(mensagem:String){
        println("enviar email")
    }
}

class NotificacaoSMS : Notificacao{
    override fun notificarUsuario(mensagem:String){
        println("enviar sms")
    }
}

class NotificacaoPush : Notificacao{
    override fun notificarUsuario(mensagem:String){
        println("enviar push")
    }
}

class FabricaNotificacao {
    public fun criarNotificacao(mensagem:String):Notificacao?{
        if(mensagem == "email")
        return NotificacaoEmail()
        else if(mensagem == "push")
        return NotificacaoPush()
        else if(mensagem == "SMS")
        return NotificacaoSMS
        else
        return null
    }
}

class Cliente {
    private val fabricaNotificacao = FabricaNotificacao()
    public fun principal(){

    }
}
