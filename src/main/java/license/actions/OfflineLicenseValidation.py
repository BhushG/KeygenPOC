from Crypto.PublicKey import RSA
from Crypto.Signature import PKCS1_v1_5
from Crypto.Hash import SHA256
import base64


if __name__ == "__main__":
    PUBLIC_KEY = """-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6ghX7Yr/24g/QW0v2XXw
8JChkQP9lJqzuS6nHJuA3jxnayrtKaR/IFVjUEBHIB9lIXFviL+b2lHKKewV2td1
8AokSkvF3wf+w5Onbu/SxFSJVDNHqgEf9mT7zXXmvwNm6IRh3ccJJqj91gvHf+oL
toNsBUtHor2vIMF9HqZfIbBCHaJfK6B8xtsD4pTaQNwT4QuPE7i90CFheyXYSCjv
WnTXMw4ntGVkZfL4QLwNUOhmhCKVggdo20w/JjPzYwm99ovHztq3hgrfa3pgGSKy
frXFX73dTiIH3mzxFHPNpHSaU4R7mYIXtYGOyuo7OiZLoqEcgnghB7r6RJvuO8UI
kwIDAQAB
-----END PUBLIC KEY-----"""

    LICENSE_KEY = "eyJuYW1lIjoicHJhZnVsIHJhbmEiLCAidmFsaWQiOiAidG9tb3Jyb3cifQ==.m3ZP1_NwXG0Z8lxdIYa2NVy6lwb6sR2pQWGwqh6Gn_NGzoHJfqCCeZ4b7cMgr5Ubi_1munyZKddk6q7cs97IdvSwOfTvTFSzpmCmzpeeY_5s68KcKaQfLIlVpU7u0-N9JdRTNzeDerOXAwniHpX9iB6YzoFJm4a9I0mhIcT2KcTuKWtFFlzuzhb61lIWh3kH3oCMFUAt4d2gkG5tpBPen8hfAVUZXQxVCKyRfzPxmrrCYojfRDEIS1JTbIxiCnUS4pBbPREfbGYv5mgA2yzDtUU14k5w7KGNTEjIEbLNkGGQ4XxWtaUYSz0bRigU1h5erXw0ElGQIEeTlHmRJWvWFQ=="
    # Split license key to obtain key and signature, then decode base64url encoded values
    enc_key, enc_sig = LICENSE_KEY.split(".")
    key = base64.urlsafe_b64decode(enc_key)
    sig = base64.urlsafe_b64decode(enc_sig)

    # Verify the key's signature
    pub_key = RSA.importKey(PUBLIC_KEY)
    verifier = PKCS1_v1_5.new(pub_key)
    digest = SHA256.new(data=key)

    print(digest)
    print(sig)
    print(
        verifier.verify(digest, sig)
    )
