package java112.project3;

import java.util.*;

/**
 *  This is a JavaBean to demonstrate using beans with JSP.
 *
 *@author    djcadd
 */
public class HttpRequestData {

    private String remoteComputer;
    private String addressRemoteComputer;
    private String httpRequest;
    private String requestUri;
    private StringBuffer requestUrl;
    private String protocolRequest;
    private String serverName;
    private int serverPort;
    private Locale currentLocale;
    private String queryString;
    private String queryParameter;
    private String requestHeader;

    /**
     *  Constructor for the HttpRequestData object
     */
    public HttpRequestData() {

    }

    public String getRemoteComputer() {
        return remoteComputer;
    }

    public String getAddressRemoteComputer() {
        return addressRemoteComputer;
    }

    public String getHttpRequest() {
        return httpRequest;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public StringBuffer getRequestUrl() {
        return requestUrl;
    }

    public String getProtocolRequest() {
        return protocolRequest;
    }

    public String getServerName() {
        return serverName;
    }

    public int getServerPort() {
        return serverPort;
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public String getQueryString() {
        return queryString;
    }

    public String getQueryParameter() {
        return queryParameter;
    }

    public String getRequestHeader() {
        return requestHeader;
    }

    public void setRemoteComputer(String remoteComputer) {
        this.remoteComputer = remoteComputer;
    }

    public void setAddressRemoteComputer(String addressRemoteComputer) {
        this.addressRemoteComputer = addressRemoteComputer;
    }

    public void setHttpRequest(String httpRequest) {
        this.httpRequest = httpRequest;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public void setRequestUrl(StringBuffer requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void setProtocolRequest(String protocolRequest) {
        this.protocolRequest = protocolRequest;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public void setQueryParameter(String queryParameter) {
        this.queryParameter = queryParameter;
    }

    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }











}
