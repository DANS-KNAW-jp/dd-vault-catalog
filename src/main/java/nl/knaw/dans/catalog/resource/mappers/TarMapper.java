/*
 * Copyright (C) 2022 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.knaw.dans.catalog.resource.mappers;

import nl.knaw.dans.catalog.api.TarDto;
import nl.knaw.dans.catalog.api.TarParameterDto;
import nl.knaw.dans.catalog.api.TarPartDto;
import nl.knaw.dans.catalog.core.domain.TarParameters;
import nl.knaw.dans.catalog.db.Tar;
import nl.knaw.dans.catalog.db.TarPart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {OcflObjectVersionMapper.class})
public interface TarMapper {
    TarMapper INSTANCE = Mappers.getMapper(TarMapper.class);

    @Mapping(source = "ocflObjectVersions", target = "versions")
    TarParameters convert(TarDto tarDto);

    @Mapping(source = "ocflObjectVersions", target = "versions")
    TarParameters convert(TarParameterDto tarParameterDto);

    TarDto convert(Tar tar);

    @Mapping(source = "tar.tarUuid", target = "tarUuid")
    TarPartDto convert(TarPart tarPart);

}