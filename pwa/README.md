# Progressive Web Application

# Two APIs, one goal

- [Push API](https://developer.mozilla.org/en-US/docs/Web/API/Push_API)와 [Notification API](https://developer.mozilla.org/en-US/docs/Web/API/Notifications_API)는 서로 별개의 API 입니다.
- **Push**는 클라이언트 사이드의 개입없이 서버에서 앱으로 새로운 컨텐츠를 전달할 때 사용합니다. 이는 앱의 서비스 워커(Service Worker)에 의해 처리됩니다.
- **Notifications**는 사용자에게 새로운 정보를 보여주거나 경고할 때 서비스 워커에의해서 사용됩니다.
- 이 둘은 브라우저 윈도우 바깥에서 동작합니다.
- 따라서 앱을 끄더라도 업데이트가 푸쉬되고 알림창이 보여질 수 있습니다.

# Notifications

## Request permission

- Notification 서비스를 사용할려면 먼저 권한을 요청해야합니다.

# Push

- Push는 Notification 서비스보다 복잡합니다.
- 앱으로 데이터를 전송하는 서버를 구독(Subscribe)해야 합니다.
- 앱의 **서비스 워커(Service Worker)**는 푸쉬 서버로부터 데이터를 받아 사용자에게 보여집니다.
- 앞서 언급했듯이, 푸쉬 메시지를 받기 위해서 서비스 워커(Service Worker)가 필요합니다. 이 개념에 대한 기초 내용은 [Making PWAs work offline with Service workers
  ](https://developer.mozilla.org/en-US/docs/Web/Progressive_web_apps/Offline_Service_workers) 글에서 이미 설명했습니다.
- 서비스 워커 내부에서 푸쉬 서비스 구독 메커니즘이 생성됩니다.

# Reference

- [How to make PWAs re-engageable using Notifications and Push](https://developer.mozilla.org/en-US/docs/Web/Progressive_web_apps/Re-engageable_Notifications_Push)
