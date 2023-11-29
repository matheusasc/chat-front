package edu.ifam.chat.chatfront.DTO;

import java.util.Calendar;

public class MensagemDTO {

    private Calendar dataHora;
    private String conteudo;
    private Long emissorId;
    private Long receptorId;


    public MensagemDTO() {
    }

    public MensagemDTO(Calendar dataHora, String conteudo, Long emissorId, Long receptorId) {
        this.dataHora = dataHora;
        this.conteudo = conteudo;
        this.emissorId = emissorId;
        this.receptorId = receptorId;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Long getEmissorId() {
        return emissorId;
    }

    public void setEmissorId(Long emissorId) {
        this.emissorId = emissorId;
    }

    public Long getReceptorId() {
        return receptorId;
    }

    public void setReceptorId(Long receptorId) {
        this.receptorId = receptorId;
    }
}

