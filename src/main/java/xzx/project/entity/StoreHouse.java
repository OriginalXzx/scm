package xzx.project.entity;

import java.io.Serializable;

public class StoreHouse implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1132840223910933970L;

	private String shId;  //�ֿ���

    private String shName; //�ֿ�����

    private String shResponsible; //������

    private String shPhone; //��ϵ�绰

    private String shAddress; //��ϵ��ַ

    private String shType; //�ֿ�����

    private String shRemark; //��ע

    public String getShId() {
        return shId;
    }

    public void setShId(String shId) {
        this.shId = shId;
    }

    public String getShName() {
        return shName;
    }

    public void setShName(String shName) {
        this.shName = shName;
    }

    public String getShResponsible() {
        return shResponsible;
    }

    public void setShResponsible(String shResponsible) {
        this.shResponsible = shResponsible;
    }

    public String getShPhone() {
        return shPhone;
    }

    public void setShPhone(String shPhone) {
        this.shPhone = shPhone;
    }

    public String getShAddress() {
        return shAddress;
    }

    public void setShAddress(String shAddress) {
        this.shAddress = shAddress;
    }

    public String getShType() {
        return shType;
    }

    public void setShType(String shType) {
        this.shType = shType;
    }

    public String getShRemark() {
        return shRemark;
    }

    public void setShRemark(String shRemark) {
        this.shRemark = shRemark;
    }

	@Override
	public String toString() {
		return "StoreHouse [shId=" + shId + ", shName=" + shName + ", shResponsible=" + shResponsible + ", shPhone="
				+ shPhone + ", shAddress=" + shAddress + ", shType=" + shType + ", shRemark=" + shRemark + "]";
	}
    
}