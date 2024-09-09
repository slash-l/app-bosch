### 博世华域回写制品信息

#### 制品部署 webhook payload

```
{
    "domain": "artifact",
    "event_type": "deployed",
    "data": {
    "repo_key": "sample_repo",
    "path": "sample_dir/sample.txt",
    "name": "sample.txt",
    "sha256": "sample_checksum",
    "size": 0
    },
    "subscription_key": "test",
    "jpd_origin": "https://<your_origin>",
    "source": "jfrog/<your_source>"
}
```
