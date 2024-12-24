package com.mars.NangPaGo.domain.user.factory.userinfo;

import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class GoogleUserInfo implements OAuth2UserInfo {

    private final Map<String, Object> attributes;

    @Override
    public String getProvider() {
        return "google";
    }

    @Override
    public String getProviderId() {
        return getAttribute("sub");
    }

    @Override
    public String getEmail() {
        return getAttribute("email");
    }

    @Override
    public String getName() {
        return getAttribute("name");
    }

    @Override
    public String getProfileImageUrl() {
        return getAttribute("picture");
    }

    public Optional<String> getPhoneNumber() {
        return Optional.empty();
    }

    public Optional<String> getBirthDay() {
        return Optional.empty();
    }

    private String getAttribute(String key) {
        return attributes.get(key).toString();
    }

}