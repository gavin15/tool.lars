/*******************************************************************************
 * Copyright (c) 2015 IBM Corp.
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
 *******************************************************************************/
package com.ibm.ws.repository.resources;

import java.util.Collection;

import com.ibm.ws.repository.common.enums.InstallPolicy;
import com.ibm.ws.repository.common.enums.Visibility;

/**
 * Represents a Feature Resource in a repository.
 * <p>
 * This interface allows read access to fields which are specific to features.
 */
public interface EsaResource extends RepositoryResource, ApplicableToProduct {

    /**
     * Gets the symbolic name of the feature
     *
     * @return the symbolic name of the feature, or null if it has not been set
     */
    public String getProvideFeature();

    /**
     * Returns a collection of iFix IDs that this feature require
     *
     * @return a collection of iFix IDs that this feature requires, or null if no iFixes are required
     */
    public Collection<String> getRequireFix();

    /**
     * Gets the list of required features for this feature
     *
     * @return The list of required features for this feature, or null if no features are required
     */
    public Collection<String> getRequireFeature();

    /**
     * Gets the short name for this feature, as defined by the IBM-ShortName header
     *
     * @return The short name for this feature, or null if it has not been set
     */
    public String getShortName();

    /**
     * Gets a lower case version of the {@link #getShortName()}.
     *
     * @return The lower cased short name, or null if it has not been set
     */
    public String getLowerCaseShortName();

    /**
     * Returns the value of the ibmProvisionCapability field (from the
     * "IBM-Provision-Capability" header in the ESA's manifest) which gives
     * information about the capabilities required to be present for the feature
     * to be provisioned.
     *
     * @return the value of the "IBM-Provision-Capability" header, or null if it has not been set
     */
    public String getProvisionCapability();

    /**
     * Returns the install policy for this feature.
     * <p>
     * A feature with an install policy of {@link InstallPolicy#WHEN_SATISFIED} should be installed automatically
     * if all of its provisioning capabilities are satisfied.
     *
     * @return The install policy for this feature, or null if it has not been set
     */
    public InstallPolicy getInstallPolicy();

    /**
     * Returns the {@link Visibility} for this feature.
     * <p>
     * This is taken from the visibility directive in the SubsystemSymbolicName header in the feature manifest.
     *
     * @return the visibility, or null if it has not been set
     */
    public Visibility getVisibility();

}
