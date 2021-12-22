# Simple demonstration project for a issue with spring boot and thymeleaf

## Expected behaviour
The expected behaviour can be seen when changing the spring boot version to 2.5.6. With this version, the linked css 
can be retrieved and the form POST is working.

## Current behaviour
The problematic behaviour starts with spring boot version 2.6.0 and is still present in 2.6.1. On the first visit, 
when there is no cookie saved in the browser, the CSS cannot be retrieved. The form POST does also not work. The 
page does work as intended when it is refreshed in the browser.

## Possible reason for the error
When visiting the page for the first time, no cookie is sent in the request header. Spring boot responds to this 
with a set-cookie-header in the response, and additionally the links in the HTML (to get the CSS and the action in 
the form) are appended with the JSESSIONID-parameter. Spring boot up to including 2.5.6 is apparently capable of 
processing requests with the JSESSIONID-parameter. Starting with version 2.6.0, requests with this parameter lead to 
errors. 
