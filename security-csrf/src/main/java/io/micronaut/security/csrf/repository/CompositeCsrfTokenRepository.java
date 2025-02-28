/*
 * Copyright 2017-2024 original authors
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
package io.micronaut.security.csrf.repository;

import io.micronaut.context.annotation.Primary;
import io.micronaut.core.annotation.Internal;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

/**
 * Composite Pattern implementation of {@link CsrfTokenRepository}.
 * @see <a href="https://guides.micronaut.io/latest/micronaut-patterns-composite.html">Composite Pattern</a>
 * @param <T> Request
 */
@Internal
@Primary
@Singleton
final class CompositeCsrfTokenRepository<T> implements CsrfTokenRepository<T> {
    private final List<CsrfTokenRepository<T>> repositories;

    /**
     *
     * @param repositories CSRF Token Repositories
     */
    public CompositeCsrfTokenRepository(List<CsrfTokenRepository<T>> repositories) {
        this.repositories = repositories;
    }

    @Override
    @NonNull
    public Optional<String> findCsrfToken(@NonNull T request) {
        return repositories.stream()
                .flatMap(r -> r.findCsrfToken(request).stream())
                .findFirst();
    }
}
