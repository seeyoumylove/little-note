package top.whatimiss.littlenote.kafka.vo;

/**
 * @author wcj
 * @create 2020/11/10 下午2:44
 * @description
 */
public class SendMeilVO {
    //标题
    private String subject;
    //内容
    private String text;
    //接收人
    private String to;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "SendMeilVO{" +
                "subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
