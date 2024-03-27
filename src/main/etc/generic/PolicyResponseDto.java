package main.etc.generic;

import java.util.Map;


public class PolicyResponseDto implements DataConverter<PolicyResponseDto>{
    private String name;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public PolicyResponseDto toModel(Map map) {
        PolicyResponseDto policyResponseDto = new PolicyResponseDto();
        policyResponseDto.setName((String) map.get("name"));
        policyResponseDto.setContent((String) map.get("content"));
        return policyResponseDto;
    }
}
