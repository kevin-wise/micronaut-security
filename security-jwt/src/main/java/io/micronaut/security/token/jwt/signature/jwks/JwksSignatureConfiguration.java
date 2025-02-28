/*
 * Copyright 2017-2023 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.security.token.jwt.signature.jwks;

import com.nimbusds.jose.jwk.KeyType;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.naming.Named;

/**
 * JSON Web Key Set Configuration.
 *
 * @author Sergio del Amo
 * @since 1.1.0
 */
public interface JwksSignatureConfiguration extends Named {

    /**
     * Json Web Key Set endpoint url.
     * @return returns a url where a JWKS is exposed.
     */
    @NonNull
    String getUrl();

    /**
     * Representation the KeyType for this JWKS signature configuration. KeyType is the kty parameter in a JSON Web Key (JWK).
     * @return The KeyType for the JWKS signature configuration.
     */
    @Nullable
    KeyType getKeyType();

    /**
     * @deprecated Not used. JWKS is cached via Micronaut Cache. You need an implementation of Micronaut Cache and the cache configuration micronaut.caches.jwks.expire-after-write
     * @return The number of seconds to cache the JWKS.
     */
    @NonNull
    @Deprecated(forRemoval = true, since = "4.11.0")
    Integer getCacheExpiration();
}
