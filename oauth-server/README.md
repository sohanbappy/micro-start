### Get Token
localhost:9292/oauth/token ({body[form] ->grant_type=password,username=sohan,password=bappy},authentication[basic]-> username=appointment,password=bappy )

### Check token
localhost:9292/oauth/check_token?token={YOUR_access_token} (authentication[basic]-> username=appointment,password=bappy)

