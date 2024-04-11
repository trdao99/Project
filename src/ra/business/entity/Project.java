package ra.business.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Project implements Serializable {
    private int projectId;
    private String projectName;
    private String projectDescription;
    private int contractId;
    private int leader_id;
    private int totalMember;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean status;
    private String technology;

    public Project() {
    }

    public Project(int projectId, String projectName, String projectDescription, int contractId, int leader_id, int totalMember, LocalDate startDate, LocalDate endDate, boolean status, String technology) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.contractId = contractId;
        this.leader_id = leader_id;
        this.totalMember = totalMember;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.technology = technology;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getLeader_id() {
        return leader_id;
    }

    public void setLeader_id(int leader_id) {
        this.leader_id = leader_id;
    }

    public int getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(int totalMember) {
        this.totalMember = totalMember;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return String.format("ID : %d | tên dự án : %s | mô tả dự án : %s | ID hợp đồng : %d | ID leader : %d | tổng thành viên : %d | ngày bắt đầu dự án : %s | ngày kết thúc dự án : %s | status : %s | công nghệ :%s ", projectId, projectName, projectDescription, contractId, leader_id, totalMember, startDate, endDate, status?"đang thực hiện":"đã hoàn thành", technology);
    }
}
